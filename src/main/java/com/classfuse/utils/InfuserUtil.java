package com.classfuse.utils;

import static org.burningwave.core.assembler.StaticComponentContainer.Fields;

import java.util.*;

import com.classfuse.Infuser;
import com.classfuse.annotations.Infused;
import com.classfuse.annotations.Qualifier;
import org.burningwave.core.classes.FieldCriteria;

import java.lang.reflect.Field;

public class InfuserUtil {

    private InfuserUtil() {
        super();
    }

    /**
     * Perform infusion recursively, for each service inside the Client class
     */
    public static void autowire(Infuser injector, Class<?> classz, Object classInstance)
            throws InstantiationException, IllegalAccessException {
        Collection<Field> fields = Fields.findAllAndMakeThemAccessible(
                FieldCriteria.forEntireClassHierarchy().allThoseThatMatch(field ->
                        field.isAnnotationPresent(Infused.class)
                ),
                classz
        );
        for (Field field : fields) {
            String qualifier = field.isAnnotationPresent(Qualifier.class)
                    ? field.getAnnotation(Qualifier.class).value()
                    : null;
            Object fieldInstance = injector.getBeanInstance(field.getType(), field.getName(), qualifier);
            Fields.setDirect(classInstance, field, fieldInstance);
            autowire(injector, fieldInstance.getClass(), fieldInstance);
        }
    }

}

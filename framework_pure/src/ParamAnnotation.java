package  etu1819.framework.annotationDao;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ParamAnnotation {
    String description();
}

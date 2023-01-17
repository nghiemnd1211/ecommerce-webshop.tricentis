package models.components;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME) //time to apply: runtime
@Target(value = ElementType.TYPE) // object to apply
public @interface ComponentCssSelector {
    String value();
}

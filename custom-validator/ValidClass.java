@Constraint(validatedBy = ValidConstraintClass.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidClass {
    String message() default "Some default message.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
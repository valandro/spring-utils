public class ValidConstraintClass implements ConstraintValidator<ValidConveniosUtilizados, ClassToValidated> {
    @Override
    public void initialize(ValidConveniosUtilizados constraintAnnotation) {

    }

    @Override
    public boolean isValid(ConvenioAvista request, ConstraintValidatorContext context) {
        return false;
    }

    private void addConstraintViolation(String message, String field, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message)
                .addPropertyNode(field)
                .addConstraintViolation();
    }
}

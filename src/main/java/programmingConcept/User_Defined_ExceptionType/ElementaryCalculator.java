package programmingConcept.User_Defined_ExceptionType;

public class ElementaryCalculator {
    private int num1;
    private int num2;

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int divide2Nums() throws CustomExceptionType {
        int divideResult = -1;
        try {
            divideResult = this.num1 / this.num2;
        } catch (Exception e) {
            throw new CustomExceptionType(e.toString());
        }
        return divideResult;
    }

    public static void main(String[] args) {
        ElementaryCalculator elementaryCalculator = new ElementaryCalculator();
        elementaryCalculator.setNum1(2);
        elementaryCalculator.setNum2(0);

        try{
            System.out.println(elementaryCalculator.divide2Nums());
        } catch (CustomExceptionType e) {
            System.out.println(e);
        }
    }
}

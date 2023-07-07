public class Mapping{
    String className;
    String Method;


    //  CONSTRUCTEURS 

    public Mapping(String className, String method) {
        this.className = className;
        Method = method;
    }

    //GETTERS SETTERS 

    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public String getMethod() {
        return Method;
    }
    public void setMethod(String method) {
        Method = method;
    }


}
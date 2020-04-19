package Sergey.Ekkel;

import java.io.IOException;
class Programs{
    public static void main(String[]args){
        /*try{
            AlwaysExceptions ae = new AlwaysExceptions(1);
            try{
                ae.method();
            } catch(Throwable t) {
                System.out.println(t.getMessage());
            } finally{
                ae.close();
            }
        }catch(Throwable t){
            System.out.println(t.getMessage());
        }*/
        try{
            SuppressedExceptions3.doAlwaysExceptions();
        }catch(Throwable e){
            System.out.println(e.getMessage());
            for(Throwable t: e.getSuppressed())
                System.out.println(t.getMessage() +" (подавленное)");
        }
    }
}

public class SuppressedExceptions3 {
    /*public static void doAlwaysExceptions() throws IOException{
        AlwaysExceptions ae = new AlwaysExceptions(1);
        Throwable suppressed = null;
        try{
            ae.method();
        } catch(Throwable t){
            suppressed = t;
            throw t;
        } finally {
            try{
                ae.close();
            }catch(Throwable t){
                if(suppressed != null)
                    t.addSuppressed(suppressed);
                throw t;
            }
        }
    }*/
    public static void doAlwaysExceptions() throws IOException{
        try(AlwaysExceptions ae = new AlwaysExceptions(1)){
            ae.method();
        }
    }

}

public class ComputerFactory {
    public static Computer getComputer(String computerType){
        if(computerType == null){
            return null;
        }
        if(computerType.equalsIgnoreCase("PC")){
            return new PC();

        } else if(computerType.equalsIgnoreCase("Server")){
            return new Server();

        } else if(computerType.equalsIgnoreCase("Notebook")){
            return new Notebook();
        }

        return null;
    }
}

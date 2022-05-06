public class Server implements Computer {
    @Override
    public void construct(String CPU, String RAM, String Storage, String GPU){
        System.out.println("Szerver elkészült: " +
                "\nProcesszor: "+CPU +
                "\nMemória: "+RAM +
                "\nTárhely: "+Storage +
                "\nGrafikus kártya: "+GPU);
    }
}
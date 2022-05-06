public class Notebook implements Computer {
    @Override
    public void construct(String CPU, String RAM, String Storage, String GPU){
        System.out.println("Notebook elkészült: " +
                "\nProcesszor: "+CPU +
                "\nMemória: "+RAM +
                "\nTárhely: "+Storage +
                "\nGrafikus kártya: "+GPU);
    }
}
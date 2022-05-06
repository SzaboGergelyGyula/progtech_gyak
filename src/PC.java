public class PC implements Computer {
    @Override
    public void construct(String CPU, String RAM, String Storage, String GPU){

        System.out.println("PC elkészült: " +
                "\nProcesszor: "+CPU +
                "\nMemória: "+RAM +
                "\nTárhely: "+Storage +
                "\nGrafikus kártya: "+GPU);
    }
}

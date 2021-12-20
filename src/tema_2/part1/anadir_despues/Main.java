package tema_2.part1.anadir_despues;

public class Main
{
    public static void main(String[] args) {
        DoubleLinkedList<String> l1=new DoubleLinkedList<String>();;

        System.out.println("===Esta en medio de la lista===");
        l1.addNode("ana");l1.addNode("jon");l1.addNode("amaia");l1.addNode("luis");;l1.addNode("ander");
        l1.printNodeList();
        l1.addAfter("peio","amaia");
        l1.printNodeList();

        l1.reset();

        System.out.println("===Esta al principio de la lista===");
        l1.addNode("ana");l1.addNode("jon");l1.addNode("amaia");l1.addNode("luis");;l1.addNode("ander");
        l1.printNodeList();
        l1.addAfter("peio","ana");
        l1.printNodeList();

        l1.reset();

        System.out.println("===No esta en la lista===");
        l1.addNode("ana");l1.addNode("jon");l1.addNode("amaia");l1.addNode("luis");;l1.addNode("ander");
        l1.printNodeList();
        l1.addAfter("peio","xabier");
        l1.printNodeList();
    }
}

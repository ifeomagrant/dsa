package queue;

/**
 * A Printer has a speed, in blocks of printing per step, and a queue of Docs to be printed
 * 
 * @author (sdb and PUT YOUR NAME HERE)
 * @version (2020) 
 */
public class Printer
{
    private final int speed;      // speed of this printer, blocks per step
    private final QueueADT<Doc> docs;    // Queue of documents waiting to be printed
    private final String id;      // name of this Printer
    //private int size = 0;

    private int blocksRead = 0; // blocks read

    /**
     * Constructor for objects of class Printer
     */
    public Printer(int speed, String id)
    {
      docs = new Queue<>();
      this.speed = speed;
      this.id = id;
      //this.size = 0;
    }

    /** Add a document to this printer's queue
       Display the document and printer on stdout.
       */
    public void add (Doc doc)
    {


        //////////// Do not change this println statement ///////////////
        docs.add(doc);
        System.out.println(doc + " added to " + this);
    }

    /** Print several blocks, if necessary, determined by this printer's speed.
     * Display a completion message, if necessary.
     *
     */
    public void print()
    {
        if(docs.peek() == null) {

        }else if(blocksRead < docs.peek().size()){
            blocksRead += speed;
            if(blocksRead < docs.peek().size()) {
                System.out.println("document printing: " + id + " has " + blocksRead +
                        " out of " + docs.peek().size() + " blocks read.");
            }
        }else if(blocksRead >= docs.peek().size()) {
            System.out.println("document " + docs.peek() + " is finish printing");
            docs.remove();
        }
    }

    /** @return the number of documents in this Printer's queue */
    public int size()
    {   return docs.size();  }

    public String toString()
    {   return id + ", speed: " + speed + ", docs in queue: " + size();  }
}

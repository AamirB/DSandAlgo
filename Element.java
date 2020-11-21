
public class Element {

    int count;
    int number;

    @Override
    public boolean equals(Object e) {
        if(this == e){
            return true;
        }


        if(e == null || e.getClass() != this.getClass()){
            return false;
        }

        Element copy = (Element)e;
        return copy.number == this.number;
    }


    public Element(int number) {
        this.number = number;
    }

    public Element(int number, int count) {
        this.number = number;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

   @Override
   public String toString() {
      return new StringBuilder().append("NUMBER ").append(number).append(" COUNT ").append(count).toString();
   }

}
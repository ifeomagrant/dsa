package list;

 class ArrayIterator<E> implements Iterator<E>{
    /** An Iterator for Arraylist.
     * @autthor solv & ___*
     */

     /** ndx is the position of the last value returned by next()
      * value returned by next()
      * @return
      */
     int ndx = -1;
     List<E> list;
     ArrayIterator(List<E> list){
         this.list = list;
     }

     @Override
     public boolean hasNext() {
         return ndx < list.size()-1;
     }

     @Override
     public E next() {
         ndx++;
         return list.get(ndx);
     }

     @Override
     public void remove() {
        list.remove(ndx);
        ndx--;
     }
 }

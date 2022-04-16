package CollectionPlus;

public class List {
    private Object[] arr;

    public List() {
        arr = new Object[0];
    }

    public void add(Object item) {
        Object[] temp = new Object[arr.length + 1];

        System.arraycopy(arr, 0, temp, 0, arr.length);

        temp[temp.length - 1] = item;
        arr = temp;
    }

    public Object get(int index) {
        return arr[index];
    }

    public void set(int index, Object value) {
        arr[index] = value;
    }

    public int[] getIndexes(Object item) {
        List indexes = new List();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == item) {
                indexes.add(i);
            }
        }

        int[] intArr = new int[indexes.count()];
        for(int i =0; i < indexes.count(); i++) {
            intArr[i] = (int)indexes.get(i);
        }

        return intArr;
    }

    public int getFirstIndexOfItem(Object item) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == item) {
                return i;
            }
        }

        return -1;
    }

    public void removeLast() {
        Object[] temp = new Object[arr.length - 1];

        System.arraycopy(arr, 0, temp, 0, temp.length);

        arr = temp;
    }

    public void removeFirst() {
        Object[] temp = new Object[arr.length - 1];
        System.arraycopy(arr, 1, temp, 0, temp.length);

        arr = temp;
    }

    public void removeAt(int index) {
        if(index == 0) {
            removeFirst();
            return;
        }
        else if (index > arr.length - 1) {
            removeLast();
            return;
        }

        Object[] temp = new Object[arr.length - 1];
        System.arraycopy(arr, 0, temp, 0, index);
        System.arraycopy(arr, index + 1, temp, index, arr.length - index - 1);

        arr = temp;
    }

    public void removeWhen(Object item) {
        List temp = new List();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != item) {
                temp.add(arr[i]);
            }
        }

        arr = temp.toArray();
    }


    public Object dequeue() { //Epic queue moment
        Object last = arr[arr.length - 1];
        removeLast();

        return last;
    }

    public Object pop() { //Epic stack moment
        Object first = arr[0];
        removeFirst();

        return first;
    }


    /*public void removeInRange(int first, int second) {
        if(first > second) {
            int tempInt = first;
            first = second;
            second = tempInt;
        }

        Object[] temp = new Object[arr.length - (second - first)];
        System.arraycopy(arr, 0, temp, 0, first);

        if(second != arr.length) {
            System.arraycopy(arr, first + 1, temp, second, arr.length - (second - first) - 1);
        }

        arr = temp;
    }*/

    /*public void RemoveTypes(Type type) { //Remove all items that contain a specific type
        List temp = new List();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i].getClass() != type) {
                temp.Add(arr[i]);
            }
        }

        arr = temp.ToArray();
    }


    public void KeepType(Type type) { //Remove all items that aren't in this specific type
        List temp = new List();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i].getClass() == type) {
                temp.Add(arr[i]);
            }
        }

        arr = temp.ToArray();
    }*/


    public void sort() { //Sorts as a string
        Object[] temp = arr;

        boolean flag = true;
        while(flag) {
            flag = false;

            for(int i = 0; i < temp.length -1 ; i++) {
                if (temp[i] instanceof Integer && temp[i + 1] instanceof Integer) { //In case it's an integer
                    if((Integer)temp[i] > (Integer)temp[i + 1]) {
                        flag = true;
                        int t = (Integer)temp[i];
                        temp[i] = temp[i + 1];
                        temp[i + 1] = t;
                    }
                }
                else { //Else (compare the objects as a string)
                    int compare = temp[i].toString().compareTo(temp[i + 1].toString());

                    if(compare > 0) {
                        flag = true;
                        Object t = temp[i];
                        temp[i] = temp[i + 1];
                        temp[i + 1] = t;
                    }
                }
            }
        }

        arr = temp;
    }

    public Object[] toArray() {
        return arr;
    }

    public boolean isEmpty() {
        if(arr.length <= 0) {
            return true;
        }
        return false;
    }

    public boolean containsOneType() {
        boolean oneType = true;
        for(int i = 0; i < arr.length - 1; i++) {
            if(!arr[i].getClass().equals(arr[i+1].getClass())) {
                return false;
            }
        }

        return true;
    }

    public boolean contains(Object item) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == item) {
                return true;
            }
        }

        return false;
    }

    public int count() {
        return arr.length;
    }
}

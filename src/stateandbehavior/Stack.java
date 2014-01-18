package stateandbehavior;
import java.util.ArrayList;

public class Stack {
    ArrayList StringList;

    {
        StringList = new ArrayList<String>();
    }

    public void push(String str)
    {
        this.StringList.add(str);
    }

    public String pop()
    {
        try {
            String r;
            r = (String) this.StringList.get(this.StringList.size() - 1);
            this.StringList.remove(this.StringList.size() - 1);
            return r;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public String peek(int i)
    {
        try {
            return (String) this.StringList.get(this.StringList.size()-1-i);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public int getSize()
    {
        return this.StringList.size();
    }

    public static void main (String[] Args)
    {
        Stack s = new Stack();
        RandomStringGenerator rString = new RandomStringGenerator();

        s.push(rString.getRandomString());
        System.out.println(s.StringList);
        s.push(rString.getRandomString());
        System.out.println(s.StringList);
        s.push(rString.getRandomString());
        System.out.println(s.StringList);

        System.out.println(s.pop());
        System.out.println(s.StringList);
        System.out.println(s.pop());
        System.out.println(s.StringList);
        System.out.println(s.pop());
        System.out.println(s.StringList);
    }
}

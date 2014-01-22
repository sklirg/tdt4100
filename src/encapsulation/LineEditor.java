package encapsulation;
public class LineEditor {

	String text; int insertionIndex = 0;
	
	public void left() { 
		if (this.insertionIndex > 0) 
		{ 
			this.insertionIndex--; 
		} 
	}

	public void right() { 
		if (this.insertionIndex < this.text.length()) 
		{ 
			this.insertionIndex++; 
		} 
	}

	public void insertString(String s) {
		this.text = this.text.substring(0, this.insertionIndex) + s + this.text.substring(this.insertionIndex);
		this.insertionIndex += s.length();
	}
	
	public void deleteLeft()  {
		if (this.insertionIndex > 0)
		{ 
			this.text = this.text.substring(0, this.insertionIndex-1) + this.text.substring(this.insertionIndex); 
			this.insertionIndex--; 
		}
	}
	
	public void deleteRight() {
		if (this.text.length() > this.insertionIndex)
		{ 
			this.text = this.text.substring(0, this.insertionIndex) + this.text.substring(this.insertionIndex+1); 
		}
	}
	
	public String toString() {
		return this.text.substring(0, this.insertionIndex) + "|" + this.text.substring(this.insertionIndex);
	}	
	public static void main(String[] args) {
		LineEditor l = new LineEditor();

		l.text = "Hai";
		l.right();
		System.out.println(l); // "H|ai"
		l.deleteRight();
		System.out.println(l); // "H|i"
		l.insertString("eee");
		System.out.println(l); // "Heee|i"
		l.deleteLeft();
		l.deleteLeft();
		System.out.println(l); // "He|i"
	}
}
package stateandbehavior;

public class Rectangle {
    int maxX;
    int maxY;
    int minX;
    int minY;


    int getMinX(){
        return this.minX;
    }

    int getMinY(){
        return this.minY;
    }

    int getMaxX(){
        return this.maxX;
    }

    int getMaxY(){
        return this.maxY;
    }

    int getWidth(){
        if (maxX == minX){
            if (maxX == 0){
                return 0;
            }
            return 1;
        }
        else {
            return ((maxX - minX) + 1); // + 1 ?
        }
    }

    int getHeight(){
        if (maxY == minY){
            if (maxY == 0) {
                return 0;
            }
            return 1;
        }
        else {
            return ((maxY - minY)+1);// +1?
        }

    }

    boolean isEmpty(){
        if (minX == 0 && maxX == 0 || minY == 0 && maxY == 0){
            return true;
        }
        return false;
    }

    boolean contains(int x, int y){
        if (minX == 0 && maxX == 0 && minY == 0 && maxY == 0){
            return false;
        }

        else if ((x >= minX && x <= maxX) && (y >= minY && y <= maxY) ){
            return true;
        }

        else {
            return false;
        }
    }

    boolean contains(Rectangle rect){
        if ((rect.minX >= this.minX && rect.maxX <= this.maxX) && (rect.minY >= this.minY && rect.maxY <= this.maxY) ){
            return true;
        }
        return false;
    }

    boolean add(int x, int y){
        boolean changed = false;

        if (minX == 0 && maxX == 0 && minY == 0 && maxY == 0){
            this.minX = this.maxX = x;
            this.minY = this.maxY = y;
            changed = true;
        }

        if (x < this.minX){
            this.minX = x;
            changed = true;
        }
        else if (x > this.maxX){
            this.maxX = x;
            changed = true;
        }

        if (y < this.minY){
            this.minY = y;
            changed = true;
        }
        else if( y > this.maxY){
            this.maxY = y;
            changed = true;
        }

        return changed;
    }

    boolean add(Rectangle rect2){
        boolean changed = false;

        if (rect2.minX < this.minX){
            this.minX = rect2.minX;
            changed = true;
        }


        if (rect2.maxX > this.maxX){
            this.maxX = rect2.maxX;

            changed = true;
        }

        if (rect2.minY < this.minY){
            this.minY = rect2.minY;

            changed = true;
        }

        if( rect2.maxY > this.maxY){
            this.maxY = rect2.maxY;

            changed = true;
        }

        //System.out.println(toString());
        return changed;

    }

    Rectangle union(Rectangle rect){
        Rectangle rect1 = new Rectangle();
        rect1.minX = this.minX;
        rect1.minY = this.minY;
        rect1.maxX = this.maxX;
        rect1.maxY = this.maxY;

        rect1.add(rect.maxX, rect.maxY);
        rect1.add(rect.minX, rect.minY);
        return rect1;
    }

    public String toString(){
        return "MaxX:" + maxX + "  MaxY:" + maxY + "  MinX:" + minX + "  MinY:" + minY + " widht:" + getWidth()  + " height"  + getHeight();
    }
}

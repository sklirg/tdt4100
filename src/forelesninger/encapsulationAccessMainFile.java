package forelesninger;

public class encapsulationAccessMainFile {
    encapsulation encapsulationObject;

    int valueFromOtherClass()
    {
        //return encapsulationObject.privateField; // not visible
        //return encapsulationObject.publicField; // visible
        return encapsulationObject.defaultField; // visible by default
    }
}

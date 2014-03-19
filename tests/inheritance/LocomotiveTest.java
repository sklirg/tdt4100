package inheritance;

import junit.framework.TestCase;
import no.hal.jex.runtime.JExercise;

@JExercise(description = "Tests inheritance.Locomotive")
@SuppressWarnings("all")
public class LocomotiveTest extends TestCase {
  private Locomotive t;
  
  private Locomotive _init_t() {
    Locomotive _locomotive = new Locomotive();
    return _locomotive;
  }
  
  private PassengerCar pc1;
  
  private PassengerCar _init_pc1() {
    PassengerCar _passengerCar = new PassengerCar(2000, 200);
    return _passengerCar;
  }
  
  private CargoCar cc1;
  
  private CargoCar _init_cc1() {
    CargoCar _cargoCar = new CargoCar(3000, 5000);
    return _cargoCar;
  }
  
  private PassengerCar pc2;
  
  private PassengerCar _init_pc2() {
    PassengerCar _passengerCar = new PassengerCar(1500, 100);
    return _passengerCar;
  }
  
  private CargoCar cc2;
  
  private CargoCar _init_cc2() {
    CargoCar _cargoCar = new CargoCar(2500, 7000);
    return _cargoCar;
  }
  
  @Override
  protected void setUp() {
    t = _init_t();
    pc1 = _init_pc1();
    cc1 = _init_cc1();
    pc2 = _init_pc2();
    cc2 = _init_cc2();
    
  }
  
  @JExercise(tests = "Locomotive();void addTrainCar(inheritance.TrainCar)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>t.addTrainCar(pc1), t.addTrainCar(pc2), t.addTrainCar(cc1)</li>\n\t\t</ul>\n")
  public void testAddCarToTrain() {
    _transition_exprAction__addCarToTrain_transitions0_actions0();
    _transition_exprAction__addCarToTrain_transitions0_actions1();
    _transition_exprAction__addCarToTrain_transitions0_actions2();
    _test__addCarToTrain_transitions0_effect_state();
    
  }
  
  @JExercise(tests = "Locomotive();void addTrainCar(inheritance.TrainCar)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>t.addTrainCar(pc1), t.addTrainCar(cc1)</li>\n\t\t<li>t.addTrainCar(pc2)</li>\n\t\t</ul>\n")
  public void testCheckTotalTrainWeight() {
    _transition_exprAction__checkTotalTrainWeight_transitions0_actions0();
    _transition_exprAction__checkTotalTrainWeight_transitions0_actions1();
    _test__checkTotalTrainWeight_transitions0_effect_state();
    _transition_exprAction__checkTotalTrainWeight_transitions1_actions0();
    _test__checkTotalTrainWeight_transitions1_effect_state();
    
  }
  
  @JExercise(tests = "Locomotive();void addTrainCar(inheritance.TrainCar)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>t.addTrainCar(pc1), t.addTrainCar(pc2)</li>\n\t\t<li>t.addTrainCar(cc1)</li>\n\t\t</ul>\n")
  public void testCheckPassengerCount() {
    _transition_exprAction__checkPassengerCount_transitions0_actions0();
    _transition_exprAction__checkPassengerCount_transitions0_actions1();
    _test__checkPassengerCount_transitions0_effect_state();
    _transition_exprAction__checkPassengerCount_transitions1_actions0();
    _test__checkPassengerCount_transitions1_effect_state();
    
  }
  
  @JExercise(tests = "Locomotive();void addTrainCar(inheritance.TrainCar)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>t.addTrainCar(cc1), t.addTrainCar(cc2)</li>\n\t\t<li>t.addTrainCar(pc1)</li>\n\t\t</ul>\n")
  public void testCheckCargoWeight() {
    _transition_exprAction__checkCargoWeight_transitions0_actions0();
    _transition_exprAction__checkCargoWeight_transitions0_actions1();
    _test__checkCargoWeight_transitions0_effect_state();
    _transition_exprAction__checkCargoWeight_transitions1_actions0();
    _test__checkCargoWeight_transitions1_effect_state();
    
  }
  
  private void _transition_exprAction__addCarToTrain_transitions0_actions0() {
    try {
      
      this.t.addTrainCar(this.pc1);
      } catch (junit.framework.AssertionFailedError error) {
      fail("t.addTrainCar(pc1) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__addCarToTrain_transitions0_actions1() {
    try {
      
      this.t.addTrainCar(this.pc2);
      } catch (junit.framework.AssertionFailedError error) {
      fail("t.addTrainCar(pc2) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__addCarToTrain_transitions0_actions2() {
    try {
      
      this.t.addTrainCar(this.cc1);
      } catch (junit.framework.AssertionFailedError error) {
      fail("t.addTrainCar(cc1) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__addCarToTrain_transitions0_effect_state() {
    _test__addCarToTrain_transitions0_effect_state_objectTests0_test();
    
  }
  
  private void _test__addCarToTrain_transitions0_effect_state_objectTests0_test() {
    
    boolean _contains = this.t.contains(this.pc1);
    assertTrue("t.contains(pc1) failed after t.addTrainCar(pc1) ,t.addTrainCar(pc2) ,t.addTrainCar(cc1)", _contains);
    
    boolean _contains_1 = this.t.contains(this.pc2);
    assertTrue("t.contains(pc2) failed after t.addTrainCar(pc1) ,t.addTrainCar(pc2) ,t.addTrainCar(cc1)", _contains_1);
    
    boolean _contains_2 = this.t.contains(this.cc1);
    assertTrue("t.contains(cc1) failed after t.addTrainCar(pc1) ,t.addTrainCar(pc2) ,t.addTrainCar(cc1)", _contains_2);
    
  }
  
  private void _transition_exprAction__checkTotalTrainWeight_transitions0_actions0() {
    try {
      
      this.t.addTrainCar(this.pc1);
      } catch (junit.framework.AssertionFailedError error) {
      fail("t.addTrainCar(pc1) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__checkTotalTrainWeight_transitions0_actions1() {
    try {
      
      this.t.addTrainCar(this.cc1);
      } catch (junit.framework.AssertionFailedError error) {
      fail("t.addTrainCar(cc1) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__checkTotalTrainWeight_transitions0_effect_state() {
    _test__checkTotalTrainWeight_transitions0_effect_state_objectTests0_test();
    
  }
  
  private void _test__checkTotalTrainWeight_transitions0_effect_state_objectTests0_test() {
    
    int _multiply = (200 * 80);
    int _plus = (2000 + _multiply);
    int _plus_1 = (8000 + _plus);
    int _totalWeight = this.t.getTotalWeight();
    assertEquals("t.getTotalWeight() == 8000 + (2000 +(200*80)) failed after t.addTrainCar(pc1) ,t.addTrainCar(cc1)", _plus_1, _totalWeight);
    
  }
  
  private void _transition_exprAction__checkTotalTrainWeight_transitions1_actions0() {
    try {
      
      this.t.addTrainCar(this.pc2);
      } catch (junit.framework.AssertionFailedError error) {
      fail("t.addTrainCar(pc2) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__checkTotalTrainWeight_transitions1_effect_state() {
    _test__checkTotalTrainWeight_transitions1_effect_state_objectTests0_test();
    
  }
  
  private void _test__checkTotalTrainWeight_transitions1_effect_state_objectTests0_test() {
    
    int _multiply = (200 * 80);
    int _plus = (2000 + _multiply);
    int _plus_1 = (8000 + _plus);
    int _multiply_1 = (100 * 80);
    int _plus_2 = (1500 + _multiply_1);
    int _plus_3 = (_plus_1 + _plus_2);
    int _totalWeight = this.t.getTotalWeight();
    assertEquals("t.getTotalWeight() == 8000 + (2000 +(200*80)) + (1500 +(100*80)) failed after t.addTrainCar(pc2)", _plus_3, _totalWeight);
    
  }
  
  private void _transition_exprAction__checkPassengerCount_transitions0_actions0() {
    try {
      
      this.t.addTrainCar(this.pc1);
      } catch (junit.framework.AssertionFailedError error) {
      fail("t.addTrainCar(pc1) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__checkPassengerCount_transitions0_actions1() {
    try {
      
      this.t.addTrainCar(this.pc2);
      } catch (junit.framework.AssertionFailedError error) {
      fail("t.addTrainCar(pc2) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__checkPassengerCount_transitions0_effect_state() {
    _test__checkPassengerCount_transitions0_effect_state_objectTests0_test();
    
  }
  
  private void _test__checkPassengerCount_transitions0_effect_state_objectTests0_test() {
    
    int _passengerCount = this.t.getPassengerCount();
    assertEquals("t.getPassengerCount() == 300 failed after t.addTrainCar(pc1) ,t.addTrainCar(pc2)", 300, _passengerCount);
    
  }
  
  private void _transition_exprAction__checkPassengerCount_transitions1_actions0() {
    try {
      
      this.t.addTrainCar(this.cc1);
      } catch (junit.framework.AssertionFailedError error) {
      fail("t.addTrainCar(cc1) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__checkPassengerCount_transitions1_effect_state() {
    _test__checkPassengerCount_transitions1_effect_state_objectTests0_test();
    
  }
  
  private void _test__checkPassengerCount_transitions1_effect_state_objectTests0_test() {
    
    int _passengerCount = this.t.getPassengerCount();
    assertEquals("t.getPassengerCount() == 300 failed after t.addTrainCar(cc1)", 300, _passengerCount);
    
  }
  
  private void _transition_exprAction__checkCargoWeight_transitions0_actions0() {
    try {
      
      this.t.addTrainCar(this.cc1);
      } catch (junit.framework.AssertionFailedError error) {
      fail("t.addTrainCar(cc1) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__checkCargoWeight_transitions0_actions1() {
    try {
      
      this.t.addTrainCar(this.cc2);
      } catch (junit.framework.AssertionFailedError error) {
      fail("t.addTrainCar(cc2) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__checkCargoWeight_transitions0_effect_state() {
    _test__checkCargoWeight_transitions0_effect_state_objectTests0_test();
    
  }
  
  private void _test__checkCargoWeight_transitions0_effect_state_objectTests0_test() {
    
    int _cargoWeight = this.t.getCargoWeight();
    assertEquals("t.getCargoWeight == 12000 failed after t.addTrainCar(cc1) ,t.addTrainCar(cc2)", 12000, _cargoWeight);
    
  }
  
  private void _transition_exprAction__checkCargoWeight_transitions1_actions0() {
    try {
      
      this.t.addTrainCar(this.pc1);
      } catch (junit.framework.AssertionFailedError error) {
      fail("t.addTrainCar(pc1) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__checkCargoWeight_transitions1_effect_state() {
    _test__checkCargoWeight_transitions1_effect_state_objectTests0_test();
    
  }
  
  private void _test__checkCargoWeight_transitions1_effect_state_objectTests0_test() {
    
    int _cargoWeight = this.t.getCargoWeight();
    assertEquals("t.getCargoWeight == 12000 failed after t.addTrainCar(pc1)", 12000, _cargoWeight);
    
  }
  
  public static void main(final String[] args) {
    no.hal.jex.standalone.JexStandalone.main(LocomotiveTest.class);
  }
}
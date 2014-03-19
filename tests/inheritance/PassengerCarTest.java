package inheritance;

import junit.framework.TestCase;
import no.hal.jex.runtime.JExercise;

@JExercise(description = "Tests inheritance.PassengerCar")
@SuppressWarnings("all")
public class PassengerCarTest extends TestCase {
  private PassengerCar pc;
  
  private PassengerCar _init_pc() {
    PassengerCar _passengerCar = new PassengerCar(3000, 200);
    return _passengerCar;
  }
  
  @Override
  protected void setUp() {
    pc = _init_pc();
    
  }
  
  @JExercise(tests = "PassengerCar(int,int);void setPassengerCount(int)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>pc.setPassengerCount(100)</li>\n\t\t</ul>\n")
  public void testCheckWeight() {
    _test__checkWeight_transitions0_source_state(pc);
    _transition_exprAction__checkWeight_transitions0_actions0(pc);
    _test__checkWeight_transitions0_effect_state(pc);
    
  }
  
  private void _test__checkWeight_transitions0_source_state(final PassengerCar it) {
    _test__checkWeight_transitions0_source_state_objectTests0_test(pc);
    
  }
  
  private void _test__checkWeight_transitions0_source_state_objectTests0_test(final PassengerCar it) {
    
    int _multiply = (200 * 80);
    int _plus = (3000 + _multiply);
    int _totalWeight = this.pc.getTotalWeight();
    assertEquals("pc.getTotalWeight() == 3000 + (200*80) failed after pc.setPassengerCount(100)", _plus, _totalWeight);
    
  }
  
  private void _transition_exprAction__checkWeight_transitions0_actions0(final PassengerCar it) {
    try {
      
      this.pc.setPassengerCount(100);
      } catch (junit.framework.AssertionFailedError error) {
      fail("pc.setPassengerCount(100) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__checkWeight_transitions0_effect_state(final PassengerCar it) {
    _test__checkWeight_transitions0_effect_state_objectTests0_test(pc);
    
  }
  
  private void _test__checkWeight_transitions0_effect_state_objectTests0_test(final PassengerCar it) {
    
    int _passengerCount = this.pc.getPassengerCount();
    assertEquals("pc.getPassengerCount() == 100 failed after pc.setPassengerCount(100)", 100, _passengerCount);
    
    int _multiply = (100 * 80);
    int _plus = (3000 + _multiply);
    int _totalWeight = this.pc.getTotalWeight();
    assertEquals("pc.getTotalWeight() == 3000 + (100*80) failed after pc.setPassengerCount(100)", _plus, _totalWeight);
    
  }
  
  public static void main(final String[] args) {
    no.hal.jex.standalone.JexStandalone.main(PassengerCarTest.class);
  }
}
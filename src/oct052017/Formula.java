package oct052017;

import java.util.Map;

import java.util.Set;

 

public abstract class Formula {

public abstract boolean evaluate(Map<Variable, Boolean> a);

 

public abstract Set<Variable> vars();

}
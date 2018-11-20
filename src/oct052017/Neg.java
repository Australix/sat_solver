package oct052017;

import java.util.Map;

import java.util.Set;

 

public class Neg extends Formula {

Formula f;

 

public Neg(Formula v) {
	f = v;
}

 

@Override

public boolean evaluate(Map<Variable, Boolean> a) {

return !f.evaluate(a);

}

 

public String toString() {

return "!" + f.toString();

}

 

@Override

public Set<Variable> vars() {

return f.vars();

}

 

}

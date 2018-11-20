package oct052017;

import java.util.HashSet;

import java.util.Map;

import java.util.Set;

 

public class And extends Formula {

Formula left, right;

 

public And(Formula l, Formula r) {

left = l;

right = r;

}

 

@Override

public boolean evaluate(Map<Variable, Boolean> a) {

return left.evaluate(a) && right.evaluate(a);

}

 

public String toString() {

return "(" + left + " && " + right + ")";

}

 

@Override

public Set<Variable> vars() {

Set<Variable> s = new HashSet<Variable>();

s.addAll(left.vars());

s.addAll(right.vars());

return s;

}

}
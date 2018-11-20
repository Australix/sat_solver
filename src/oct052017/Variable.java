package oct052017;



import java.util.HashSet;

import java.util.Map;

import java.util.Set;

 

public class Variable extends Formula {

String name;

 

public Variable(String n) {

name = n;

}

 

@Override

public boolean evaluate(Map<Variable, Boolean> a) {

return a.get(this);

}

 

public String toString() {

return name;

}

 

@Override

public Set<Variable> vars() {

Set<Variable> s = new HashSet<Variable>();

s.add(this);

return s;

}

}
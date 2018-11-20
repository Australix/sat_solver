package oct052017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import oct052017.And;
import oct052017.Formula;
import oct052017.Neg;
import oct052017.Or;
import oct052017.Variable;

public class Solver {
	private int countSols = 0;
	private int countNonSols = 0;
	private List<String> allSols = new ArrayList<String>(); 
	
	public List<String> solve(Formula f) {
		solve(f, f.vars(), new HashMap<Variable, Boolean>());
		System.out.println("#solutions: " + countSols + "; #non-solutions: " + countNonSols);
		return allSols;
	}
	
	public void reset() {
		countSols = 0;
		countNonSols = 0;
		allSols.clear();
	}
	
	private void solve(Formula f, Set<Variable> vars, Map<Variable, Boolean> assignment) {
		if (vars.isEmpty()) {
			if (f.evaluate(assignment)) {
				countSols++;
				allSols.add(assignment.toString());
			} else countNonSols++;
			return;
		}
		Variable v = vars.iterator().next();
		vars.remove(v);
		assignment.put(v, false);
		solve(f, vars, assignment);
		assignment.put(v, true);
		solve(f, vars, assignment);
		vars.add(v);
	}
	
	public static void main(String[] arg) {
		Solver solver = new Solver();
		 
		Variable a = new Variable("a");
		Variable b = new Variable("b");
		Variable c = new Variable("c");
		
		// a && b
		Formula f = new And(a, b);
		System.out.println(f);
		List<String> sols = solver.solve(f);
		System.out.println("all solutions: " + sols);
		solver.reset();
		System.out.println("--------");
		 
		f = new And(a, new Neg(b));
		System.out.println(f);
		sols = solver.solve(f);
		System.out.println("all solutions: " + sols);
		solver.reset();
		System.out.println("--------");
		 
		// (a || b) && !(a && b)
		f = new And(new Or(a, b), new Neg(new And(a, b)));
		System.out.println(f);
		sols = solver.solve(f);
		System.out.println("all solutions: " + sols);
		solver.reset();
		System.out.println("--------");
		 
		// a || (b || c)
		f = new Or(a, new Or(b, c));
		System.out.println(f);
		sols = solver.solve(f);
		System.out.println("all solutions: " + sols);
		solver.reset();
		System.out.println("--------");
	}

}
package ppg.experiment.java.monads.javascripttojava;

import org.javatuples.Pair;

import java.util.function.Function;

interface DoubleToPairFunction<V1, V2> extends Function<Double, Pair<V1, V2>> {

}

package ppg.experiment.java.monads.javascripttojava;

import org.javatuples.Pair;

import java.util.function.Function;

interface PairToPairFunction<V1, V2> extends Function<Pair<V1, V2>, Pair<V1, V2>> {

}

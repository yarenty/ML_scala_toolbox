package com.yarenty.math.correlation

import com.yarenty.Log
import org.apache.commons.math3.stat.correlation.SpearmansCorrelation

case object Spearmans extends Correlation {
  override def correlate(expected: Array[Double], observed: Array[Double]): Double = {
    checks(expected, observed)
    try {
      new SpearmansCorrelation().correlation(expected, observed)
    } catch {
      case e: Exception =>
        Log.warn(e)
        Double.NaN
    }
  }
}

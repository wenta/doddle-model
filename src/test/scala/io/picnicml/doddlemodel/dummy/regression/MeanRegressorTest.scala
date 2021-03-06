package io.picnicml.doddlemodel.dummy.regression

import io.picnicml.doddlemodel.data.loadBostonDataset
import io.picnicml.doddlemodel.dummy.regression.MeanRegressor.ev
import org.scalatest.{FlatSpec, Matchers, OptionValues}

class MeanRegressorTest extends FlatSpec with Matchers with OptionValues {

  "Mean regressor" should "infer the correct mean from the boston housing dataset" in {
    val (x, y) = loadBostonDataset
    val model = MeanRegressor()
    val trainedModel = ev.fit(model, x, y)
    trainedModel.mean.value shouldBe 22.532806324110666
    ev.predict(trainedModel, x).toArray.forall(_ == 22.532806324110666) shouldBe true
  }
}

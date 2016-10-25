package net.zenhack.randomDroid

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.{EditText, TextView}

class Random extends Activity with TypedFindView {
    implicit val context = this

    override def onCreate(savedInstanceState: Bundle): Unit = {
        super.onCreate(savedInstanceState)
        TypedViewHolder.setContentView(this, TR.layout.main)
    }

    private def orElse(res: TypedResource[EditText], default: BigInt): BigInt =
      findView(res).getText().toString() match {
        case "" => default
        case intStr => BigInt(intStr)
      }

    private def choose(left: BigInt, right: BigInt): BigInt = {
      // TODO: verify and document that this gives the right distribution.
      val range = (left - right).abs
      (BigInt(range.bitLength, scala.util.Random) % range) + (left min right)
    }

    def generate(view: View): Unit = findView(TR.answer).setText(
        choose(
          orElse(TR.left, TR.integer.left.value),
          orElse(TR.right,TR.integer.right.value)
        ).toString()
      )
}

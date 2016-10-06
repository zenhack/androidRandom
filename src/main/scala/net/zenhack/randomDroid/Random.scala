package net.zenhack.randomDroid

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.{EditText, TextView}

class Random extends Activity with TypedFindView {
    private var randGen: java.util.Random = new java.util.Random

    implicit val context = this

    override def onCreate(savedInstanceState: Bundle): Unit = {
        super.onCreate(savedInstanceState)
        TypedViewHolder.setContentView(this, TR.layout.main)
    }

    private def orElse(res: TypedResource[EditText], default: Int): Int =
      findView(res).getText().toString() match {
        case "" => default
        case intStr => Integer.parseInt(intStr)
      }

    private def choose(left: Int, right: Int): Int =
      randGen.nextInt(Math.abs(left - right) + 1) + Math.min(left, right)

    def generate(view: View): Unit = findView(TR.answer).setText(
        choose(
          orElse(TR.left, TR.integer.left.value),
          orElse(TR.right,TR.integer.right.value)
        ).toString()
      )
}

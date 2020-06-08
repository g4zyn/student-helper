package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import rs.raf.projekat2.marko_gajin_RM8517.R
import rs.raf.projekat2.marko_gajin_RM8517.extensions.toPx
import timber.log.Timber

class SquareView : View {

    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context,attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr : Int) : super(context, attrs, defStyleAttr)

    private var rect : Rect = Rect()
    private var paint : Paint = Paint()

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Timber.e("On measure")
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        Timber.e("On layout")
    }

    var heightDivider = 1

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Timber.e("On draw")

        // 1st bar
        val left = 0
        val top = height / heightDivider
        val bottom = height
        val right = width / 5

        rect.set(left, bottom, right, top)

        // Colors
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL
        paint.color = ContextCompat.getColor(context, R.color.colorPrimary)

        canvas?.drawRect(rect, paint)

        paint.color = ContextCompat.getColor(context, R.color.colorPrimaryDark)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 4.toPx().toFloat()

        canvas?.drawRect(rect, paint)

//        2nd
        val top2 = height / heightDivider / 2
        val bottom2 = height
        val right2 = width * 2 / 5

        rect.set(right, top2, right2, bottom2)

        paint.style = Paint.Style.FILL
        paint.color = ContextCompat.getColor(context, R.color.colorPrimary)

        canvas?.drawRect(rect, paint)
        paint.color = ContextCompat.getColor(context, R.color.colorPrimaryDark)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 4.toPx().toFloat()

        canvas?.drawRect(rect, paint)

//        3rd
        val top3 = height / heightDivider / 3
        val bottom3 = height
        val right3 = width * 3 / 5

        rect.set(right2, top3, right3, bottom3) // Ovo nam kaze gde cemo da iscrtamo

        // A sad treba da iscrtamo ili ti obojimo
        paint.style = Paint.Style.FILL
        paint.color = ContextCompat.getColor(context, R.color.colorPrimary)

        canvas?.drawRect(rect, paint)

        paint.color = ContextCompat.getColor(context, R.color.colorPrimaryDark)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 4.toPx().toFloat()

        canvas?.drawRect(rect, paint)

        //Crtamo cetvrti bar

        val left4 = right3
        val top4 = height / heightDivider / 4
        val bottom4 = height
        val right4 = width * 4 / 5

        rect.set(left4, top4, right4, bottom4) // Ovo nam kaze gde cemo da iscrtamo

        // A sad treba da iscrtamo ili ti obojimo
        paint.style = Paint.Style.FILL
        paint.color = ContextCompat.getColor(context, R.color.colorPrimary)

        canvas?.drawRect(rect, paint)

        paint.color = ContextCompat.getColor(context, R.color.colorPrimaryDark)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 4.toPx().toFloat()

        canvas?.drawRect(rect, paint)

        //Crtamo peti bar

        val left5 = right4
        val top5 = height / heightDivider / 1
        val bottom5 = height
        val right5 = width

        rect.set(left5, top5, right5, bottom5) // Ovo nam kaze gde cemo da iscrtamo

        // A sad treba da iscrtamo ili ti obojimo
        paint.style = Paint.Style.FILL
        paint.color = ContextCompat.getColor(context, R.color.colorPrimary)

        canvas?.drawRect(rect, paint)

        paint.color = ContextCompat.getColor(context, R.color.colorPrimaryDark)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 4.toPx().toFloat()

        canvas?.drawRect(rect, paint)

    }
}
package com.infinum.isa.playground.lectureeight

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.OvershootInterpolator
import android.widget.FrameLayout
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import com.infinum.isa.playground.R
import com.infinum.isa.playground.databinding.ViewSuperheroItemBinding

class SuperheroCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var binding: ViewSuperheroItemBinding

    init {
//        inflate(context, R.layout.view_superhero_item, this)
        binding = ViewSuperheroItemBinding.inflate(LayoutInflater.from(context), this)

        val pixelPadding = context.resources.getDimensionPixelSize(R.dimen.card_padding)
        setPadding(pixelPadding, pixelPadding, pixelPadding, pixelPadding)

        clipToPadding = false
    }

    // TODO: Create method for setting title
    fun setTitle(title: String) {
        binding.superheroName.text = title
    }

    // TODO: Create method for setting image
    fun setImage(@DrawableRes imageResource: Int) {
        binding.superheroImage.setImageResource(imageResource)
    }

    // TODO: Create animation for title to translate from left to right on click
    fun animateTitle() {
        with(binding.superheroName) {
            translationX = 100f
            animate()
                .translationX(200f)
                .setDuration(1000)
                .setInterpolator(OvershootInterpolator())
                .start()
        }
    }
}
package com.star.designsystem.components.toolbar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import com.star.designsystem.databinding.ToolbarBinding

class AppToolbar(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding: ToolbarBinding = ToolbarBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    private val backButton: AppCompatImageButton by lazy { binding.backButton }

}

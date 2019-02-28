package com.arturszymanski.basiskotlinmvp.view.base

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import com.arturszymanski.basiskotlinmvp.R

/**
 * Base Dialog Fragment that should be used with any Dialog fragment that don't have presenter. If your Dialog Fragment
 * has presenter use [BasePresenterDialogFragment] instead.
 * This class makes dialog fragment fullscreen so can be used to create any layout.
 * @param O Dialog Fragment owner interface that is used to communicate with it`s parent. Parent have to implement this
 * interface in other case [IllegalStateException] will be thrown.
 */
abstract class BaseDialogFragment<O> : DialogFragment() {
    var owner : O? = null

    @Suppress("UNCHECKED_CAST")
    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if(activity != null && getOwnerClass().isAssignableFrom(activity!!.javaClass)) {
            owner = activity as O
        }
        else if (parentFragment != null && getOwnerClass().isAssignableFrom(parentFragment!!.javaClass)) {
                owner = parentFragment as O
        }
        else {
            throw IllegalStateException(
                "Parent Activity or Fragment of ${this::class.simpleName} dialog have to implement it's owner ${getOwnerClass().simpleName}")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.AppTheme)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog : Dialog = super.onCreateDialog(savedInstanceState)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }

    override fun onDetach() {
        owner = null

        super.onDetach()
    }

    /**
     * Ask for type of owner interface used to communicate with owner. Your parent of this dialog should implement that
     * owner interface what allows to call actions from this fragment dialog to parent.
     * @return Owner type that should be passed ass O::class.java
     */
    abstract fun getOwnerClass() : Class<O>
}
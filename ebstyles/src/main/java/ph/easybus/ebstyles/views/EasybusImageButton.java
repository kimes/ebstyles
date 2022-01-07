package ph.easybus.ebstyles.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageButton;

import ph.easybus.ebstyles.R;

public class EasybusImageButton extends AppCompatImageButton {

    private static final int[] STATE_ENABLED = { android.R.attr.state_enabled };

    public EasybusImageButton(Context context) {
        super(context);
    }

    public EasybusImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.EasybusImageButton);
        try {
            boolean enabled = a.getBoolean(R.styleable.EasybusImageButton_android_enabled, true);
            setEnabled(enabled);
        } finally {
            a.recycle();
        }
    }

    public int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);

        if (isEnabled()) mergeDrawableStates(drawableState, STATE_ENABLED);
        return drawableState;
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        refreshDrawableState();
    }
}

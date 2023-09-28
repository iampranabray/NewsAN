import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role

@Composable
fun RadioButtonOption(
    text: String,
    isSelected: Boolean,
    onOptionSelected: () -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .selectable(
                selected = isSelected,
                role = Role.RadioButton,
                onClick = { onOptionSelected },
            ),

        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = isSelected, onClick = onOptionSelected
        )
        Text(text= text)
    }
}
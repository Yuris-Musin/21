package ru.musindev.ochko

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun DynamicOverlappingCards(
    cardResIds: List<Int>,
    modifier: Modifier = Modifier,
    cardHeightDp: Int = 120
) {
    Layout(
        content = {
            cardResIds.forEach { resId ->
                Image(
                    painter = painterResource(id = resId),
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight
                )
            }
        },
        modifier = modifier
    ) { measurables, constraints ->
        val cardCount = measurables.size

        if (cardCount == 0) {
            layout(constraints.maxWidth, cardHeightDp.dp.roundToPx()) {}
        } else {
            val cardHeightPx = cardHeightDp.dp.roundToPx()
            val totalWidth = constraints.maxWidth

            // Стандартное соотношение сторон игральной карты (2:3)
            val cardAspectRatio = 2f / 3f
            val cardWidthPx = (cardHeightPx * cardAspectRatio).roundToInt()

            // Шаг смещения между картами, чтобы колода заняла всю ширину
            val stepPx = if (cardCount > 1) {
                (totalWidth - cardWidthPx).toFloat() / (cardCount - 1)
            } else {
                0f
            }

            // Измеряем каждую карту с фиксированными размерами
            val placeables = measurables.map { measurable ->
                measurable.measure(
                    constraints.copy(
                        minWidth = cardWidthPx,
                        maxWidth = cardWidthPx,
                        minHeight = cardHeightPx,
                        maxHeight = cardHeightPx
                    )
                )
            }

            // Размещаем карты с перекрытием
            layout(width = totalWidth, height = cardHeightPx) {
                placeables.forEachIndexed { index, placeable ->
                    val xPosition = (index * stepPx).roundToInt()
                    placeable.placeRelative(x = xPosition, y = 0)
                }
            }
        }
    }
}


//@Composable
//fun CardFan(
//    cardResIds: List<Int>,
//    modifier: Modifier = Modifier,
//    cardHeightDp: Int = 120,
//    aspectRatio: Float = 0.72f // ширина/высота для стандартной карты (пример: 100/150=0.66)
//) {
//    Layout(
//        content = {
//            cardResIds.forEach { resId ->
//                Image(
//                    painter = painterResource(resId),
//                    contentDescription = null,
//                    modifier = Modifier.height(cardHeightDp.dp),
//                    contentScale = ContentScale.FillHeight
//                )
//            }
//        },
//        modifier = modifier
//    ) { measurables, constraints ->
//        val count = measurables.size
//        if (count == 0) {
//            layout(constraints.maxWidth, cardHeightDp.dp.roundToPx()) {}
//        } else {
//            val cardHeightPx = cardHeightDp.dp.roundToPx()
//            val cardWidthPx = (cardHeightPx * aspectRatio).roundToInt()
//            // Шаг — насколько каждая карта смещена относительно предыдущей:
//            val totalWidth = constraints.maxWidth
//            val step = if (count > 1) {
//                ((totalWidth - cardWidthPx).toFloat() / (count - 1)).coerceAtLeast(0f)
//            } else 0f
//
//            val placeables = measurables.map {
//                it.measure(constraints.copy(
//                    minWidth = cardWidthPx,
//                    maxWidth = cardWidthPx,
//                    minHeight = cardHeightPx,
//                    maxHeight = cardHeightPx
//                ))
//            }
//            layout(totalWidth, cardHeightPx) {
//                placeables.forEachIndexed { i, p ->
//                    p.placeRelative(x = (i * step).roundToInt(), y = 0)
//                }
//            }
//        }
//    }
//}


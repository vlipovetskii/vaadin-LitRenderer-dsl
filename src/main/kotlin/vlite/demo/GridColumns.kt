package vlite.demo

import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.data.renderer.LitRenderer
import kotlinx.css.*
import vlite.demo.dsl.KLumoLineHeight
import vlite.demo.dsl.buildLitRenderer
import vlite.demo.dsl.style
import vlite.demo.dsl.theme
import kotlin.collections.component1
import kotlin.collections.component2

fun Grid<GridRow>.addColumn(): Grid.Column<GridRow> {


    return addColumn(
        buildLitRenderer<GridRow> {

            val field1 = "field1" { row ->
                row.field1
            }

            val field2 = "field2" { row ->
                row.field2
            }

            val field3 = "field3" { row ->
                row.field3
            }

            templateExpression {

                horizontalLayout(style { alignItems = Align.start; /* height = 20.rem; */ }, theme(spacing)) {

                    verticalLayout(style {
                        lineHeight = +KLumoLineHeight.XS; /* height = 100.pct */; whiteSpace = WhiteSpace.preWrap
                    }) {
                        span {
                            +field1
                        }
                    }

                    verticalLayout(style { alignItems = Align.start; lineHeight = +KLumoLineHeight.XS; }) {

                        horizontalLayout(theme(spacing)) {
                            span {
                                +"field2: "
                            }
                            span {
                                +field2
                            }
                        }

                        horizontalLayout(theme(spacing)) {
                            span {
                                +"field3: "
                            }
                            span {
                                +field3
                            }
                        }

                    }

                }
            }

        }
    )
}

fun Grid<GridRow>.addColumnAsString(): Grid.Column<GridRow> {

    val templateExpression = """
            <vaadin-horizontal-layout style="align-items: start" theme="spacing">
                        <vaadin-vertical-layout style="line-height: var(--lumo-line-height-xs); white-space: pre-wrap">
            <span >
${ "\${item.field1}" }
</span>
            </vaadin-vertical-layout>            <vaadin-vertical-layout style="align-items: start; line-height: var(--lumo-line-height-xs)">
                        <vaadin-horizontal-layout theme="spacing">
            <span >
field2: 
</span><span >
${ "\${item.field2}" }
</span>
            </vaadin-horizontal-layout>            <vaadin-horizontal-layout theme="spacing">
            <span >
field3: 
</span><span >
${ "\${item.field3}" }
</span>
            </vaadin-horizontal-layout>
            </vaadin-vertical-layout>
            </vaadin-horizontal-layout>
"""


    return addColumn(
        LitRenderer.of<GridRow>(templateExpression).apply {
            withProperty("field1") { it.field1 }
            withProperty("field2") { it.field2 }
            withProperty("field3") { it.field3 }
        }
    )
}


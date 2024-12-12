package vlite.demo

import com.vaadin.flow.component.grid.Grid
import kotlinx.css.*
import vlite.demo.dsl.KLumoLineHeight
import vlite.demo.dsl.buildLitRenderer
import vlite.demo.dsl.style
import vlite.demo.dsl.theme

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
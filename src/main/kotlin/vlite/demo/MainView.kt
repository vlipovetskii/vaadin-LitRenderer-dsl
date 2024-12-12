package vlite.demo

import com.github.mvysny.karibudsl.v10.grid
import com.github.mvysny.karibudsl.v10.span
import com.vaadin.flow.component.icon.VaadinIcon
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route

@Suppress("unused")
@Route("/")
class MainView : VerticalLayout() {

    init {
        span("MainView")


        grid<GridRow> {

            addColumn().setHeader("Demo of column built with KLitRendererDsl")

            setItems(
                GridRow("a1", "a2", "a3"),
                GridRow("b1", "b2", "b3"),
            )

        }

    }

}
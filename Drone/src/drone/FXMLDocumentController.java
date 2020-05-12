package drone;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.util.Duration;


/**
 * @author andre
 * Class conntroler from javaFX, here we set drone's configs
 */

/**
 * @Attributes
 * Rectangle: scenario obstacles, orange obstacle represents the destiny
 * Line s: are drone's sensors
 */

public class FXMLDocumentController {

    @FXML
    private Pane fundo;

    @FXML
    private Rectangle chegada;

    @FXML
    private Button entrar;

    @FXML
    private Text coordenada;

    @FXML
    private Text prolog;

    @FXML
    private Rectangle barreira7;

    @FXML
    private Rectangle barreira9;

    @FXML
    private Rectangle barreira4;

    @FXML
    private Rectangle barreira5;

    @FXML
    private Line s3;

    @FXML
    private Line s5;

    @FXML
    private Line s4;

    @FXML
    private Line s6;

    @FXML
    private Rectangle barreira6;

    @FXML
    private Line s2;

    @FXML
    private Line s1;

    @FXML
    private ImageView drone;

    @FXML
    private Line barreira;

    @FXML
    private Line barreira2;

    @FXML
    private Line barreira3;

    @FXML
    private Line barreira8;

    double x = 1, y = 1, px, py, dx, dy, passos = 30, incx = 0, incy = 0, gtx, gty;

    int[] senso = new int[6];
    int tempoAni = 1;
    int controlex = 1, controley = 1;

    /** 
     * @param figuras rectangles
     * implements the dragging of the rectangles from scenario
     */
    
    private void arrastarItens(final Shape figuras) {
        figuras.setOnMousePressed((MouseEvent event) -> {
            x = figuras.getLayoutX() - event.getSceneX();
            y = figuras.getLayoutY() - event.getSceneY();
            figuras.setCursor(Cursor.CROSSHAIR);
        });
        figuras.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                figuras.setCursor(Cursor.HAND);
            }
        });
        figuras.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                figuras.setLayoutX(event.getSceneX() + x);
                figuras.setLayoutY(event.getSceneY() + y);
            }
        });

    }
    
    /**
     *complements arrastarItens
     */
    private void criafiguras() {
        List<Shape> obstaculos = new ArrayList<>();
        obstaculos.add(barreira);
        obstaculos.add(chegada);
        obstaculos.add(barreira2);
        obstaculos.add(barreira3);
        obstaculos.add(barreira4);
        obstaculos.add(barreira5);
        obstaculos.add(barreira6);
        obstaculos.add(barreira7);
        obstaculos.add(barreira8);
        obstaculos.add(barreira9);
        for (Shape moveFiguras : obstaculos) {
            arrastarItens(moveFiguras);

        }

    }

    /**
     * drone's animation
     */
    
    private void Chegada() {

        if (objetivo()) {

            TranslateTransition t = new TranslateTransition(Duration.seconds(3));
            TranslateTransition t1 = new TranslateTransition(Duration.seconds(3));
            TranslateTransition t2 = new TranslateTransition(Duration.seconds(3));
            TranslateTransition t3 = new TranslateTransition(Duration.seconds(3));
            TranslateTransition t4 = new TranslateTransition(Duration.seconds(3));
            TranslateTransition t5 = new TranslateTransition(Duration.seconds(3));
            TranslateTransition t6 = new TranslateTransition(Duration.seconds(3));

            t.setNode(drone);
            t1.setNode(s1);
            t2.setNode(s2);
            t3.setNode(s3);
            t4.setNode(s4);
            t5.setNode(s5);
            t6.setNode(s6);

            t.setDuration(Duration.seconds(4));
            t1.setDuration(Duration.seconds(4));
            t2.setDuration(Duration.seconds(4));
            t3.setDuration(Duration.seconds(4));
            t4.setDuration(Duration.seconds(4));
            t5.setDuration(Duration.seconds(4));
            t6.setDuration(Duration.seconds(4));

            t.setToX(chegada.getLayoutX());
            t.setToY(chegada.getLayoutY());
            t.play();

            t1.setToX(chegada.getLayoutX());
            t1.setToY(chegada.getLayoutY());
            t1.play();

            t2.setToX(chegada.getLayoutX());
            t2.setToY(chegada.getLayoutY());
            t2.play();

            t3.setToX(chegada.getLayoutX());
            t3.setToY(chegada.getLayoutY());
            t3.play();

            t4.setToX(chegada.getLayoutX());
            t4.setToY(chegada.getLayoutY());
            t4.play();

            t5.setToX(chegada.getLayoutX());
            t5.setToY(chegada.getLayoutY());
            t5.play();

            t6.setToX(chegada.getLayoutX());
            t6.setToY(chegada.getLayoutY());
            t6.play();

            // JOptionPane.showMessageDialog(null, "Chegou!");
            //drone.setTranslateX(0);
            //drone.setTranslateY(0);

            /* s1.setTranslateX(0);
            s1.setTranslateY(0);

            s2.setTranslateX(0);
            s2.setTranslateY(0);

            s3.setTranslateX(0);
            s3.setTranslateY(0);

            s4.setTranslateX(0);
            s4.setTranslateY(0); */
        }
    }

    @FXML
    void arrastar(MouseEvent event) {
        criafiguras();
    }

    /**
     * drones's animation
     * @param event 
     */
    
    @FXML
    void movimento(MouseEvent event) {

        senso[0] = 0;
        senso[1] = 0;
        senso[2] = 0;
        senso[3] = 0;
        senso[4] = 0;
        senso[5] = 0;

        s1.setVisible(false);
        s2.setVisible(false);
        s3.setVisible(false);
        s4.setVisible(false);
        s5.setVisible(false);
        s6.setVisible(false);
        trajeto(chegada.getLayoutX() / passos, chegada.getLayoutY() / passos, tempoAni);
    }

    private void trajeto(double a, double b, int tempo) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(tempo));
        TranslateTransition t1 = new TranslateTransition(Duration.seconds(tempo));
        TranslateTransition t2 = new TranslateTransition(Duration.seconds(tempo));
        TranslateTransition t3 = new TranslateTransition(Duration.seconds(tempo));
        TranslateTransition t4 = new TranslateTransition(Duration.seconds(tempo));
        TranslateTransition t5 = new TranslateTransition(Duration.seconds(tempo));
        TranslateTransition t6 = new TranslateTransition(Duration.seconds(tempo));

        t.setNode(drone);
        t1.setNode(s1);
        t2.setNode(s2);
        t3.setNode(s3);
        t4.setNode(s4);
        t5.setNode(s5);
        t6.setNode(s6);

        /*if (drone.getTranslateX() > chegada.getLayoutX()
                && drone.getTranslateY() > chegada.getLayoutY()) {

            t.setToX(chegada.getLayoutX());
            t.setToY(chegada.getLayoutY());
            t.play();

            t1.setToX(chegada.getLayoutX());
            t1.setToX(chegada.getLayoutX());
            t1.play();

            t2.setToX(chegada.getLayoutX());
            t2.setToY(chegada.getLayoutY());
            t2.play();

            t3.setToX(chegada.getLayoutX());
            t3.setToY(chegada.getLayoutY());
            t3.play();

            t4.setToX(chegada.getLayoutX());
            t4.setToY(chegada.getLayoutY());
            t4.play();

            t5.setToX(chegada.getLayoutX());
            t5.setToY(chegada.getLayoutY());
            t5.play();

            t6.setToX(chegada.getLayoutX());
            t6.setToY(chegada.getLayoutY());
            t6.play();

        }*/
        coordenada.setText(drone.getTranslateX() + " - " + chegada.getLayoutX() + "\n"
                + drone.getTranslateY() + " - " + chegada.getLayoutY());

        if (objetivo()) {

            t.setToX(chegada.getLayoutX());
            t.setToY(chegada.getLayoutY());
            t.play();

            t1.setToX(chegada.getLayoutX());
            t1.setToX(chegada.getLayoutX());
            t1.play();

            t2.setToX(chegada.getLayoutX());
            t2.setToY(chegada.getLayoutY());
            t2.play();

            t3.setToX(chegada.getLayoutX());
            t3.setToY(chegada.getLayoutY());
            t3.play();

            t4.setToX(chegada.getLayoutX());
            t4.setToY(chegada.getLayoutY());
            t4.play();

            t5.setToX(chegada.getLayoutX());
            t5.setToY(chegada.getLayoutY());
            t5.play();

            t6.setToX(chegada.getLayoutX());
            t6.setToY(chegada.getLayoutY());
            t6.play();

        } else {
            if (!colisao()) {

                t.setByX(a);
                t.setByY(b);
                t.play();

                t1.setByX(a);
                t1.setByY(b);
                t1.play();

                t2.setByX(a);
                t2.setByY(b);
                t2.play();

                t3.setByX(a);
                t3.setByY(b);
                t3.play();

                t4.setByX(a);
                t4.setByY(b);
                t4.play();

                t5.setByX(a);
                t5.setByY(b);
                t5.play();

                t6.setByX(a);
                t6.setByY(b);
                t6.play();

                t.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        coordenada.setText(drone.getTranslateX() + " - " + chegada.getLayoutX() + "\n"
                                + drone.getTranslateY() + " - " + chegada.getLayoutY());

                        if (!colisao()) {
                            trajeto((chegada.getLayoutX() - incx) / passos, (chegada.getLayoutY() - incy) / passos, tempoAni);
                        }
                        if (colisao()) {

                            Conexao c = new Conexao();
                            double[] xy = c.conectar(senso);

                            x = xy[0];

                            /*(Double.parseDouble(JOptionPane.showInputDialog("Coord X sensores: " + senso[0] + " "
                                    + senso[1] + " " + senso[2] + " " + senso[3]))*(controlex)); */
                            y = xy[1];

                            //(Double.parseDouble(JOptionPane.showInputDialog("Coord Y"))*controley);
                            incx = incx + (x) * controlex;
                            incy = incy + y * (controley);

                            t.setToX(drone.getTranslateX() + x * controlex);
                            t.setToY(drone.getTranslateY() + y * controley);
                            t.play();

                            t1.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {

                                    if (colisao()) {

                                        t1.setToX(s1.getTranslateX() + x * controlex);
                                        t1.setToY(s1.getTranslateY() + y * controley);
                                        t1.play();
                                    }
                                }
                            });

                            t2.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {

                                    if (colisao()) {

                                        t2.setToX(s2.getTranslateX() + x * controlex);
                                        t2.setToY(s2.getTranslateY() + y * controley);
                                        t2.play();
                                    }
                                }
                            });
                            t3.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    if (colisao()) {

                                        t3.setToX(s3.getTranslateX() + x * controlex);
                                        t3.setToY(s3.getTranslateY() + y * controley);
                                        t3.play();
                                    }
                                }
                            });
                            t4.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {

                                    if (colisao()) {

                                        t4.setToX(s4.getTranslateX() + x * controlex);
                                        t4.setToY(s4.getTranslateY() + y * controley);
                                        t4.play();
                                    }
                                }
                            });

                            t5.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {

                                    if (colisao()) {

                                        t5.setToX(s5.getTranslateX() + x * controlex);
                                        t5.setToY(s5.getTranslateY() + y * controley);
                                        t5.play();
                                    }
                                }
                            });

                            t6.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {

                                    if (colisao()) {

                                        t6.setToX(s6.getTranslateX() + x * controlex);
                                        t6.setToY(s6.getTranslateY() + y * controley);
                                        t6.play();
                                    }
                                }
                            });

                            t.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {

                                    coordenada.setText(drone.getTranslateX() + " - " + chegada.getLayoutX() + "\n"
                                            + drone.getTranslateY() + " - " + chegada.getLayoutY());
                                    if (colisao()) {

                                        Conexao c = new Conexao();
                                        double[] xy = c.conectar(senso);

                                        x = xy[0];

                                        /*(Double.parseDouble(JOptionPane.showInputDialog("Coord X sensores: " + senso[0] + " "
                                                        + senso[1] + " " + senso[2] + " " + senso[3])) * controlex);*/
                                        y = xy[1];

                                        //(Double.parseDouble(JOptionPane.showInputDialog("Coord Y")) * controley);
                                        incx = incx + x * controlex;
                                        incy = incy + y * controley;

                                        t.setToX(drone.getTranslateX() + x * controlex);
                                        t.setToY(drone.getTranslateY() + y * controley);
                                        t.play();

                                        t1.setOnFinished(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {

                                                if (colisao()) {

                                                    t1.setToX(s1.getTranslateX() + x * controlex);
                                                    t1.setToY(s1.getTranslateY() + y * controley);
                                                    t1.play();
                                                }
                                            }
                                        });

                                        t2.setOnFinished(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {

                                                if (colisao()) {

                                                    t2.setToX(s2.getTranslateX() + x * controlex);
                                                    t2.setToY(s2.getTranslateY() + y * controley);
                                                    t2.play();
                                                }
                                            }
                                        });
                                        t3.setOnFinished(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {

                                                if (colisao()) {

                                                    t3.setToX(s3.getTranslateX() + x * controlex);
                                                    t3.setToY(s3.getTranslateY() + y * controley);
                                                    t3.play();
                                                }
                                            }
                                        });
                                        t4.setOnFinished(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {

                                                if (colisao()) {

                                                    t4.setToX(s4.getTranslateX() + x * controlex);
                                                    t4.setToY(s4.getTranslateY() + y * controley);
                                                    t4.play();
                                                }
                                            }
                                        });

                                        t5.setOnFinished(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {

                                                if (colisao()) {

                                                    t5.setToX(s5.getTranslateX() + x * controlex);
                                                    t5.setToY(s5.getTranslateY() + y * controley);
                                                    t5.play();
                                                }
                                            }
                                        });

                                        t6.setOnFinished(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {

                                                if (colisao()) {

                                                    t6.setToX(s6.getTranslateX() + x * controlex);
                                                    t6.setToY(s6.getTranslateY() + y * controley);
                                                    t6.play();
                                                }
                                            }
                                        });

                                        prolog.setText("Entrada: [" + senso[0] + "," + senso[1] + "," + senso[2] + "," + senso[3] + "]\n"
                                                + "Saída: [" + x + "," + y + "]"
                                        );

                                    } else {
                                        trajeto((chegada.getLayoutX() - incx) / passos, (chegada.getLayoutY() - incy) / passos, tempoAni);
                                    }
                                }
                            });
                        }
                    }

                });

            }
        }
    }

    /**
     * test if drone is lolliding with scenary elements
     * @return boolean
     */
    
    private boolean colisao() {

        int controle = 0;

        if (Shape.intersect(s1, barreira2).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s1, barreira3).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s1, barreira4).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s1, barreira).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s1, barreira5).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s1, barreira6).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s1, barreira7).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s1, barreira8).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s1, barreira9).getBoundsInLocal().isEmpty() == false) {
            senso[0] = 1;
            controle++;

            s1.setStroke(Color.RED);
            s1.setVisible(true);
        } else {
            senso[0] = 0;
            s1.setVisible(false);
        }

        if (Shape.intersect(s2, barreira2).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s2, barreira3).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s2, barreira).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s2, barreira4).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s2, barreira5).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s2, barreira6).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s2, barreira7).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s2, barreira8).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s2, barreira9).getBoundsInLocal().isEmpty() == false) {
            senso[1] = 1;
            controle++;
            s2.setStroke(Color.RED);
            s2.setVisible(true);
        } else {
            senso[1] = 0;
            s2.setVisible(false);
        }

        if (Shape.intersect(s3, barreira2).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s3, barreira).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s3, barreira3).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s3, barreira4).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s3, barreira5).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s3, barreira6).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s3, barreira7).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s3, barreira8).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s3, barreira9).getBoundsInLocal().isEmpty() == false) {
            senso[2] = 1;
            controle++;
            s3.setStroke(Color.RED);
            s3.setVisible(true);
        } else {
            senso[2] = 0;
            s3.setVisible(false);
        }

        if (Shape.intersect(s4, barreira2).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s4, barreira3).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s4, barreira).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s4, barreira4).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s4, barreira5).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s4, barreira6).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s4, barreira7).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s4, barreira8).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s4, barreira9).getBoundsInLocal().isEmpty() == false) {
            senso[3] = 1;
            controle++;
            s4.setStroke(Color.RED);
            s4.setVisible(true);
        } else {
            senso[3] = 0;
            s4.setVisible(false);
        }

        if (Shape.intersect(s5, barreira2).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s5, barreira3).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s5, barreira).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s5, barreira4).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s5, barreira5).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s5, barreira6).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s5, barreira7).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s5, barreira8).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s5, barreira9).getBoundsInLocal().isEmpty() == false) {
            senso[4] = 1;
            controle++;
            s5.setStroke(Color.RED);
            s5.setVisible(true);
        } else {
            senso[4] = 0;
            s5.setVisible(false);
        }

        if (Shape.intersect(s6, barreira2).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s6, barreira3).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s6, barreira).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s6, barreira4).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s6, barreira5).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s6, barreira6).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s6, barreira7).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s6, barreira8).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s6, barreira9).getBoundsInLocal().isEmpty() == false) {
            senso[5] = 1;
            controle++;
            s6.setStroke(Color.RED);
            s6.setVisible(true);
        } else {
            senso[5] = 0;
            s6.setVisible(false);
        }

        if (controle > 0) {

            if (senso[0] == 1 && senso[1] == 1) {
                controlex = 1;
            }

            if (senso[0] == 0 && senso[1] == 1) {
                controlex = 1;
            }

            if (senso[0] == 1 && senso[1] == 0) {
                controlex = -1;
            }

            if (senso[1] == 1 && senso[2] == 1 && senso[0] == 0) {
                controlex = -1;
            }

            if (senso[0] == 1 && senso[1] == 1 && senso[3] == 1) {
                controlex = -1;
            }

            if (senso[1] == 1 && senso[2] == 1) {
                controlex = 1;
            }

            if (Shape.intersect(s1, barreira8).getBoundsInLocal().isEmpty() == false
                    && Shape.intersect(s2, barreira8).getBoundsInLocal().isEmpty() == false) {
                controlex = 1;

            }

            /* if (Shape.intersect(s2, barreira).getBoundsInLocal().isEmpty() == false
                    || Shape.intersect(s4, barreira).getBoundsInLocal().isEmpty() == false) {
                controlex = 1;
                controley = 1;
            }*/
            if (Shape.intersect(s5, barreira8).getBoundsInLocal().isEmpty() == false) {
                controlex = 1;
                controley = -1;
            }

            if (Shape.intersect(s6, barreira2).getBoundsInLocal().isEmpty() == false) {
                controlex = -1;

                if (drone.getTranslateY() > chegada.getTranslateY()) {
                    controley = -1;
                    controlex = 1;

                }
            }

            return true;

        } else {
            return false;
        }

    }

    /**
     * @return booelan
     * test if drone is in final destiny
     */
    
    private boolean objetivo() {
        if (Shape.intersect(s1, chegada).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s2, chegada).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s3, chegada).getBoundsInLocal().isEmpty() == false
                || Shape.intersect(s4, chegada).getBoundsInLocal().isEmpty() == false) {
            return true;
        } else {
            return false;
        }
    }

}

package com.ig.tripmemo.repository.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ApiModel(description = "All details about the Settings.")
public class Settings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated setting ID")
    private Long id;

    @ApiModelProperty(notes = "The type of the map")
    private String mapType;

    @ApiModelProperty(notes = "The URL of the map")
    private String mapUrl;

    @Column(columnDefinition = "geometry(Point, 4326)")
    @ApiModelProperty(notes = "The starting point of the map in geometry format")
    private Point startingPoint;

    @ApiModelProperty(notes = "The zoom level of the map")
    private Integer zoomLevel;

}

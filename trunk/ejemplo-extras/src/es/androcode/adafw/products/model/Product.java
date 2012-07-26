/*
 * A project sample for AdaFramework (http://www.adaframework.com/)
 * 
 * Copyright (C) 2012 Androcode
 * <http://www.androcode.es>
 * 
 * This project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this project.  If not, see <http://www.gnu.org/licenses/>.
 */

package es.androcode.adafw.products.model;


import com.desandroid.framework.ada.Entity;
import com.desandroid.framework.ada.annotations.CustomValidation;
import com.desandroid.framework.ada.annotations.Databinding;
import com.desandroid.framework.ada.annotations.RangeValidation;
import com.desandroid.framework.ada.annotations.RequiredFieldValidation;
import com.desandroid.framework.ada.annotations.Table;
import com.desandroid.framework.ada.annotations.TableField;

import es.androcode.adafw.extras.R;

@Table(name = "product")
public class Product extends Entity {

    @TableField(name = "name", datatype = DATATYPE_TEXT, required = true)
    @Databinding(ViewId = R.id.name)
    @RequiredFieldValidation(messageResourceId=R.string.error_empty_name)
    private String name;
    @TableField(name = "category", datatype = DATATYPE_ENTITY_REFERENCE, required = false)
    private Category category;
    @TableField(name = "quantity_per_unit", datatype = DATATYPE_INTEGER, required = true)
    @Databinding(ViewId = R.id.quantity)
    @RangeValidation(minValue = 1, maxValue = 9999, messageResourceId = R.string.error_quantity_range)
    private int quantityPerUnit;
    @TableField(name = "unit_price", datatype = DATATYPE_DOUBLE, required = true)
    @Databinding(ViewId = R.id.price)
    @CustomValidation(validator = PriceValidator.class, messageResourceId = R.string.error_price)
    private double unitPrice;
    @TableField(name = "units_in_stock", datatype = DATATYPE_INTEGER, required = true)
    @Databinding(ViewId = R.id.stock)
    private int unitsInStock;

    public Product() {
        super();
    }

    public Product(String name, Category category, int quantityPerUnit,
            double unitPrice, int unitsInStock) {
        super();
        this.name = name;
        this.category = category;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(int quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

}

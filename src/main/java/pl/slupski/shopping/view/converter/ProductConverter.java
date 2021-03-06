package pl.slupski.shopping.view.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import pl.slupski.shopping.service.cache.DataCache;
import pl.slupski.shopping.service.pojo.Product;

/**
 *
 * @author sluski
 */
@FacesConverter("productConverter")
public class ProductConverter implements Converter {

    @Override
    public Product getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                return DataCache.findProductByName(value);
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null && object.getClass().equals(String.class)) {
            return (String) object;
        } else {
            return null;
        }
    }
}

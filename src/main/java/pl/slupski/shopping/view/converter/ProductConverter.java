package pl.slupski.shopping.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
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
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                for(Product product : DataCache.getProducts()) {
                    return null;
                }
            } catch(Exception ex) {
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

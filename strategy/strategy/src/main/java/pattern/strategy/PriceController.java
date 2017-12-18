package pattern.strategy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2017/10/30 10:28
 * @github https://github.com/Seymour1996
 */
@Controller
public class PriceController {
    Map<String,Double> map = new HashMap<String, Double>();
    @RequestMapping("/printer")
    public String getPrinterView(){
        map.put("001",500.0);
        map.put("002",1000.0);
        map.put("003",1500.0);
        return "printer";
    }
    @ResponseBody
    @PostMapping("/calculate")
    public ModelMap calculate(@ModelAttribute Printer printer){

        PrinterPriceCalculate cal=new PrinterPriceCalculate();
        printer.setPrice(map.get(printer.name));
        try {
            cal.setPrintService((PrinterDiscount)Class.forName(printer.strategy).newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        printer.setPriceAfterDiscount(cal.getPrice(printer.getPrice(),printer.getDiscount()));
        ModelMap map = new ModelMap();
        map.addAttribute("msg","折后："+printer.getPriceAfterDiscount()+"元");
        System.out.println(printer.getPriceAfterDiscount());
        return map;
    }

}

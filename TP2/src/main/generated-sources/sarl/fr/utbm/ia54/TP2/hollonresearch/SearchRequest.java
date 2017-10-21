package fr.utbm.ia54.TP2.hollonresearch;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Event;
import java.io.File;
import java.util.Objects;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.6")
@SarlElementType(14)
@SuppressWarnings("all")
public class SearchRequest extends Event {
  public String xtensionFile;
  
  public File pathFile;
  
  public SearchRequest(final File f, final String x) {
    this.pathFile = f;
    this.xtensionFile = x;
  }
  
  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    SearchRequest other = (SearchRequest) obj;
    if (!Objects.equals(this.xtensionFile, other.xtensionFile)) {
      return false;
    }
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Objects.hashCode(this.xtensionFile);
    return result;
  }
  
  /**
   * Returns a String representation of the SearchRequest event's attributes only.
   */
  @SyntheticMember
  @Pure
  protected String attributesToString() {
    StringBuilder result = new StringBuilder(super.attributesToString());
    result.append("xtensionFile  = ").append(this.xtensionFile);
    result.append("pathFile  = ").append(this.pathFile);
    return result.toString();
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 7374285258L;
}

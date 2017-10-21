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
public class Search extends Event {
  public final String typeFile = "txt";
  
  public File startPath;
  
  public Search(final File file) {
    this.startPath = file;
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
    Search other = (Search) obj;
    if (!Objects.equals(this.typeFile, other.typeFile)) {
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
    result = prime * result + Objects.hashCode(this.typeFile);
    return result;
  }
  
  /**
   * Returns a String representation of the Search event's attributes only.
   */
  @SyntheticMember
  @Pure
  protected String attributesToString() {
    StringBuilder result = new StringBuilder(super.attributesToString());
    result.append("typeFile  = ").append(this.typeFile);
    result.append("startPath  = ").append(this.startPath);
    return result.toString();
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 1520038178L;
}

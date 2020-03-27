package com.group1.library.exception.alreadyexists;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The {@code CategoryAlreadyExistsException} class is the class of errors and
 * exceptions when an {@code Category} instance is already defined in the database.
 * Only objects that are instances of this class are thrown by the Java Virtual Machine
 * or can be thrown by the Java {@code throw} statement. Similarly, only
 * this class can be the argument type in a {@code catch} clause.
 *
 * For the purposes of compile-time checking of exceptions, {@code CategoryAlreadyExistsException}
 * that is also a subclass of either {@link Throwable} or {@link RuntimeException} are
 * regarded as checked exceptions.
 *
 * <p>Instances of two superclasses, {@link java.lang.Throwable} and {@link java.lang.RuntimeException},
 * are conventionally used to indicate that exceptional situations have occurred.
 * Typically, these instances are freshly created in the context of the exceptional situation
 * so as to include relevant information (such as stack trace data).
 *
 * <p>The reason that a {@code AdminAlreadyExistsException} may have a cause
 * is that the class that throws it is built atop a lower layered abstraction,
 * and an operation on the upper layer fails due to a failure in the lower layer.
 * It would be bad design to let the {@code AdminAlreadyExistsException} thrown
 * by the lower layer propagate outward, as it is generally unrelated to the abstraction
 * provided by the upper layer.
 */
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "This category already exists in the database.")
public class CategoryAlreadyExistsException extends Throwable {
}
